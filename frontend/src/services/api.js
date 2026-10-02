/** This service serves as the central point for all HTTP requests to the Spring Boot backend. 
 * You never have to update URLs in different places throughout the code—just here.
 */

const API_BASE_URL = 'http://localhost:8085/api';

/**
 * Retrieves all tasks associated with a specific project ID from the backend.
 */

export async function getTasksByProjectId(projectId) {
  const response = await fetch(`${API_BASE_URL}/projects/${projectId}/tasks`);
  
  if (!response.ok) {
    throw new Error(`Error loading tasks (Status: ${response.status})`);
  }
  
  return await response.json();
}
/**
 * Send new task data to spring boot backend with POST, no formular events or ui stuff here.
 * @param {} projectId 
 * @param {*} taskData 
 */
export async function createTask(projectId, taskData) {
  try{
    const response = await fetch(`${API_BASE_URL}/projects/${projectId}/tasks`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(taskData), //JS Object to JSON string
    });
    if (!response.ok) {
      // Handle error response
      throw new Error(`Error creating task (Status: ${response.status})`);
    }

    return await response.json(); // Return the created task data

  }catch (error) {
    console.error('API Error:', error);
    throw error; // Rethrow the error to be handled by the caller
  }
}