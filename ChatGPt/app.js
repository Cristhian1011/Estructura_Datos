const KEY = "chatgpt.crud.tasks";

const form = document.getElementById("task-form");
const idInput = document.getElementById("task-id");
const titleInput = document.getElementById("title");
const detailInput = document.getElementById("detail");
const searchInput = document.getElementById("search");
const list = document.getElementById("list");
const empty = document.getElementById("empty");
const itemTemplate = document.getElementById("item-template");
const modeTitle = document.getElementById("form-mode");
const saveBtn = document.getElementById("save-btn");
const cancelBtn = document.getElementById("cancel-btn");

let tasks = read();
let editId = null;

function read() {
  try {
    return JSON.parse(localStorage.getItem(KEY)) || [];
  } catch {
    return [];
  }
}

function write() {
  localStorage.setItem(KEY, JSON.stringify(tasks));
}

function clearForm() {
  editId = null;
  idInput.value = "";
  form.reset();
  modeTitle.textContent = "Nueva tarea";
  saveBtn.textContent = "Guardar";
  cancelBtn.classList.add("hidden");
}

function render() {
  const q = searchInput.value.trim().toLowerCase();
  list.innerHTML = "";

  const filtered = tasks.filter((t) => t.title.toLowerCase().includes(q));

  filtered.forEach((task) => {
    const clone = itemTemplate.content.cloneNode(true);
    const li = clone.querySelector(".item");

    li.dataset.id = task.id;
    clone.querySelector(".item-title").textContent = task.title;
    clone.querySelector(".item-detail").textContent = task.detail;
    list.append(clone);
  });

  empty.classList.toggle("hidden", filtered.length > 0);
}

function saveTask(title, detail) {
  if (editId) {
    tasks = tasks.map((t) => (t.id === editId ? { ...t, title, detail } : t));
  } else {
    tasks.unshift({ id: crypto.randomUUID(), title, detail });
  }

  write();
  render();
  clearForm();
}

function startEdit(id) {
  const task = tasks.find((t) => t.id === id);
  if (!task) {
    return;
  }

  editId = id;
  idInput.value = id;
  titleInput.value = task.title;
  detailInput.value = task.detail;
  modeTitle.textContent = "Editar tarea";
  saveBtn.textContent = "Actualizar";
  cancelBtn.classList.remove("hidden");
}

function removeTask(id) {
  tasks = tasks.filter((t) => t.id !== id);
  write();
  render();
  if (editId === id) {
    clearForm();
  }
}

form.addEventListener("submit", (e) => {
  e.preventDefault();
  const title = titleInput.value.trim();
  const detail = detailInput.value.trim();
  if (!title || !detail) {
    return;
  }
  saveTask(title, detail);
});

cancelBtn.addEventListener("click", clearForm);
searchInput.addEventListener("input", render);

list.addEventListener("click", (e) => {
  const btn = e.target.closest("button[data-action]");
  if (!btn) {
    return;
  }
  const item = btn.closest(".item");
  if (!item) {
    return;
  }

  const { id } = item.dataset;
  if (btn.dataset.action === "edit") {
    startEdit(id);
  }
  if (btn.dataset.action === "delete") {
    removeTask(id);
  }
});

render();
