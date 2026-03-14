const STORAGE_KEY = "crud.tasks.v1";

const form = document.getElementById("task-form");
const taskIdInput = document.getElementById("task-id");
const titleInput = document.getElementById("task-title");
const descriptionInput = document.getElementById("task-description");
const submitBtn = document.getElementById("submit-btn");
const cancelBtn = document.getElementById("cancel-btn");
const formTitle = document.getElementById("form-title");
const searchInput = document.getElementById("search");
const list = document.getElementById("task-list");
const emptyState = document.getElementById("empty-state");
const template = document.getElementById("task-template");

let tasks = loadTasks();
let editingId = null;

function loadTasks() {
  const data = localStorage.getItem(STORAGE_KEY);
  if (!data) {
    return [];
  }

  try {
    const parsed = JSON.parse(data);
    return Array.isArray(parsed) ? parsed : [];
  } catch {
    return [];
  }
}

function saveTasks() {
  localStorage.setItem(STORAGE_KEY, JSON.stringify(tasks));
}

function resetForm() {
  editingId = null;
  form.reset();
  taskIdInput.value = "";
  formTitle.textContent = "Agregar tarea";
  submitBtn.textContent = "Guardar";
  cancelBtn.classList.add("hidden");
}

function renderTasks() {
  const query = searchInput.value.trim().toLowerCase();
  list.innerHTML = "";

  const filtered = tasks.filter((task) => task.title.toLowerCase().includes(query));

  filtered.forEach((task) => {
    const fragment = template.content.cloneNode(true);
    const item = fragment.querySelector(".task-item");

    item.dataset.id = task.id;
    fragment.querySelector(".task-item__title").textContent = task.title;
    fragment.querySelector(".task-item__description").textContent = task.description;

    list.append(fragment);
  });

  emptyState.classList.toggle("hidden", filtered.length > 0);
}

function upsertTask(title, description) {
  if (editingId) {
    tasks = tasks.map((task) =>
      task.id === editingId
        ? {
            ...task,
            title,
            description,
            updatedAt: Date.now(),
          }
        : task
    );
  } else {
    tasks.unshift({
      id: crypto.randomUUID(),
      title,
      description,
      createdAt: Date.now(),
      updatedAt: Date.now(),
    });
  }

  saveTasks();
  renderTasks();
  resetForm();
}

function startEdit(taskId) {
  const task = tasks.find((item) => item.id === taskId);
  if (!task) {
    return;
  }

  editingId = task.id;
  taskIdInput.value = task.id;
  titleInput.value = task.title;
  descriptionInput.value = task.description;

  formTitle.textContent = "Editar tarea";
  submitBtn.textContent = "Actualizar";
  cancelBtn.classList.remove("hidden");
  titleInput.focus();
}

function removeTask(taskId) {
  tasks = tasks.filter((task) => task.id !== taskId);
  saveTasks();
  renderTasks();

  if (editingId === taskId) {
    resetForm();
  }
}

form.addEventListener("submit", (event) => {
  event.preventDefault();

  const title = titleInput.value.trim();
  const description = descriptionInput.value.trim();

  if (!title || !description) {
    return;
  }

  upsertTask(title, description);
});

cancelBtn.addEventListener("click", resetForm);
searchInput.addEventListener("input", renderTasks);

list.addEventListener("click", (event) => {
  const button = event.target.closest("button[data-action]");
  if (!button) {
    return;
  }

  const item = button.closest(".task-item");
  if (!item) {
    return;
  }

  const taskId = item.dataset.id;

  if (button.dataset.action === "edit") {
    startEdit(taskId);
  }

  if (button.dataset.action === "delete") {
    removeTask(taskId);
  }
});

renderTasks();
