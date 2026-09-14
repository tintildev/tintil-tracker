import TaskList from './components/TaskList';

export default function App() {
  return (
    <div className="min-h-screen bg-gray-50 p-8">
      <div className="max-w-4xl mx-auto">
        <header className="mb-8">
          <h1 className="text-3xl font-extrabold text-indigo-600">tintil-tracker</h1>
          <p className="text-gray-500 text-sm">Dein minimalistischer Projekt- & Task-Manager</p>
        </header>

        <main>
          {/* Lädt aktuell automatisch Projekt ID 1 */}
          <TaskList projectId={1} />
        </main>
      </div>
    </div>
  );
}