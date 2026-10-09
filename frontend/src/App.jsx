import { useEffect, useState } from 'react';
import TaskList from './components/TaskList';
import TaskForm from './components/TaskForm';
import { getTasksByProjectId } from './services/api';

export default function App() {
  const projectId = 1;
  const [tasks, setTasks] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
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

    const handleTaskCreated = (newTask) => {
    // Neuen Task oben in die bestehende Liste einfügen
    setTasks((prevTasks) => [newTask, ...prevTasks]);
  };

  return (
    <div className="min-h-screen bg-gray-50 p-8">
      <div className="max-w-4xl mx-auto">
        <header className="mb-8">
                 <h1 className="text-3xl font-extrabold text-emerald-600">tintil-tracker</h1>
          <p className="text-gray-500 text-sm">Dein minimalistischer Projekt- & Task-Manager</p>
        </header>

        <main>
          <TaskForm projectId={projectId} onTaskCreated={handleTaskCreated} />
          
          <TaskList 
            projectId={projectId} 
            tasks={tasks} 
            loading={loading} 
            error={error} 
          />
        </main>
      </div>
    </div>
  );
}