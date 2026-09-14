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