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

//POST send sata to spring boot backend
async function PostDataForm(){


  // async function to handle form submission
  const handleSubmit = async (event) => {
    // Prevent the default form submission behavior
    event.preventDefault();
    const data = {
      // Collect data from form inputs here
      // For example:
      // name: event.target.name.value,
      // email: event.target.email.value,
    };

    //Todo: Implement the logic to send data to the backend using fetch or axios

  }
  // Example using fetch to send data to the backend
  try{ const response = await fetch('https://api.example.com/users', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  });
  // error handling for the response
  if (!response.ok) {
    throw new Error(`Error sending data (Status: ${response.status})`);
  }
  const result = await response.json();
  setMessage("Send Daata successfully");
  console.log(result);
  }catch (error) {
    console.error('Error sending data:', error);
    setMessage("Error sending data");
  }
    
}