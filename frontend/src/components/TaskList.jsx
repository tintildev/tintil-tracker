import { useEffect, useState } from 'react';
import { getTasksByProjectId } from '../services/api';

export default function TaskList({ projectId = 1 }) {
  const [tasks, setTasks] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    // Daten beim Backend abrufen
    getTasksByProjectId(projectId)
      .then((data) => {
        setTasks(data);
        setLoading(false);
      })
      .catch((err) => {
        setError(err.message);
        setLoading(false);
      });
  }, [projectId]);

  if (loading) {
    return <div className="text-gray-500 font-medium">Lade Aufgaben vom Backend...</div>;
  }

  if (error) {
    return (
      <div className="bg-red-50 border border-red-200 text-red-700 p-4 rounded-lg">
        <p className="font-bold">Verbindungsfehler</p>
        <p className="text-sm">{error}</p>
      </div>
    );
  }

  return (
    <div className="space-y-4">
      <h2 className="text-xl font-bold text-gray-800">Aufgaben (Projekt #{projectId})</h2>
      
      {tasks.length === 0 ? (
        <p className="text-gray-500 italic">Keine Aufgaben für dieses Projekt gefunden.</p>
      ) : (
        <div className="grid gap-3 md:grid-cols-2">
          {tasks.map((task) => (
            <div 
              key={task.id} 
              className="p-4 bg-white border border-gray-200 rounded-lg shadow-sm hover:shadow-md transition-shadow"
            >
              <div className="flex justify-between items-start mb-2">
                <h3 className="font-semibold text-gray-900">{task.title}</h3>
                <span className="text-xs px-2.5 py-0.5 rounded-full font-medium bg-blue-100 text-blue-800">
                  {task.status}
                </span>
              </div>
              <p className="text-sm text-gray-600 mb-2">{task.description}</p>
              {task.dueDate && (
                <p className="text-xs text-gray-400">Fällig am: {task.dueDate}</p>
              )}
            </div>
          ))}
        </div>
      )}
    </div>
  );
}