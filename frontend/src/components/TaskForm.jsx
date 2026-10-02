import { useState, useEffect } from "react";
import { createTask } from "../services/api";

export default function TaskForm({projectId = 1, onTaskCreated}) {
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [status, setStatus] = useState("TODO");
    const [submitting, setSubmitting] = useState(false);
    const [error, setError] = useState(null);

    const handleSubmit = async (e) => {
        e.preventDefault();
        setSubmitting(true);
        setError(null);

        try {
            const newTask = await createTask(projectId, { title, description, status });

            //reset feelds after successful submission
            setTitle("");
            setDescription("");
            setStatus("TODO");

            // Notify parent component about the new task
            if (onTaskCreated) {
                onTaskCreated(newTask);
            }
        } catch (error) {
            setError(error.message);
        } finally {
            setSubmitting(false);
        }
    };

    return(<div className="div_task-form">
        <h1>Create Task</h1>
        <form onSubmit={handleSubmit} className="task-form">
            <h3 className="text-lg font-semibold text-gray-800">Neue Aufgabe hinzufügen</h3>

      {error && (
        <div className="text-sm text-red-600 bg-red-50 p-2.5 rounded border border-red-200">
          {error}
        </div>
      )}

      <div>
        <label className="block text-sm font-medium text-gray-700 mb-1">Titel</label>
        <input
          type="text"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          placeholder="z. B. React-Frontend refactoren"
          required
          className="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500"
        />
      </div>

      <div>
        <label className="block text-sm font-medium text-gray-700 mb-1">Beschreibung</label>
        <textarea
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          placeholder="Optionale Details zur Aufgabe..."
          rows="2"
          className="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500"
        />
      </div>

      <div>
        <label className="block text-sm font-medium text-gray-700 mb-1">Status</label>
        <select
          value={status}
          onChange={(e) => setStatus(e.target.value)}
          className="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500"
        >
          <option value="TODO">TODO</option>
          <option value="IN_PROGRESS">IN_PROGRESS</option>
          <option value="DONE">DONE</option>
        </select>
      </div>

      <button
        type="submit"
        disabled={submitting}
        className="w-full md:w-auto px-4 py-2 bg-emerald-600 hover:bg-indigo-700 text-white font-medium rounded-md shadow-sm transition-colors disabled:opacity-50"
      >
        {submitting ? 'Wird gespeichert...' : 'Aufgabe erstellen'}
      </button>
    </form>
    </div>);
}