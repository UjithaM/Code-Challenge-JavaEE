<h1>In-Memory POS System API</h1>

<h2>Overview</h2>
<p>This project is a comprehensive API for the existing front-end  POS system. It is developed using Java EE, integrating relevant specifications such as Servlet, JSON, and JNDI.</p>

<h2>Features</h2>
<ul>
  <li>Basic CRUD Operations</li>
  <li>Fundamental Validations</li>
  <li>Implementation of Appropriate Design Patterns with Thoughtful Packaging</li>
  <li>Database Integration (SQL) with JNDI</li>
  <li>Proper Logging Mechanism</li>
  <li>API Documentation (Postman may be utilized for this purpose)</li>
</ul>

<h2>Technologies Used</h2>
<ul>
  <li>Java EE</li>
  <li>Servlet</li>
  <li>JSON</li>
  <li>JNDI</li>
  <li>Hibernate (for database integration)</li>
</ul>

<h2>Prerequisites</h2>
<ul>
  <li>Java 11</li>
  <li>Apache Tomcat 10.1.17 </li>
  <li>Database (MySQL)</li>
  <li>Postman for API testing</li>
</ul>

<h2>Setup</h2>
<ol>
  <li>Clone the repository:</li>
  <code>git clone https://github.com/KasunKVI/Pos_System/---</code>
  <li>Configure your database connection in <code>src/main/resources/hibernate.cfg.xml</code>.</li>
  <li>Build and deploy the project to your Java EE server.</li>
  <li>Access the API at <code>http://localhost:8080/Pos_System</code>.</li>
</ol>

<h2>Project Structure</h2>
<ul>
  <li><strong>src/main/java/software/kasunkavinda/pos_system_backend/api</strong>: Java source files</li>
  <li><strong>src/main/resources</strong>: Configuration files</li>
  <li><strong>src/main/java/software/kasunkavinda/pos_system_backend/entity</strong>: Entity Classes</li>
  <li><strong>src/main/java/software/kasunkavinda/pos_system_backend/dto</strong>: DTO Classes</li>
  <li><strong>src/main/java/software/kasunkavinda/pos_system_backend/filter</strong>: CORS Filter</li>
  <li><strong>src/main/java/software/kasunkavinda/pos_system_backend/util</strong>: Factory Configuration</li>
  <li><strong>docs</strong>: API documentation</li>
</ul>

<h2>How to Use</h2>
<ol>
  <li>Perform CRUD operations using the provided API endpoints.</li>
 <li>Refer to the API documentation in the <code>docs</code> folder for detailed information on each endpoint.</li> 
</ol>

<h2>Logging</h2>
<p>Logging in this project is handled by <a href="https://www.slf4j.org/" target="_blank">slf4j</a>. Logs can be found in the <code>console</code></p>

<h2>API Documentation</h2>
<p>The API is documented using Postman. You can find the document here <a href="https://documenter.getpostman.com/view/27054693/2s9YsRcpCf" target="_blank">Document</a>.</p>

<h2>License</h2>
<p>This project is licensed under the <a href="LICENSE" target="_blank">MIT License</a>.</p>

<h2>Frontend Repository</h2>
<p>If you are interested in the frontend part of the POS system, you can find the corresponding GitHub repository at the following link:</p>
<p><a href="https://github.com/KasunKVI/Pos_System_FrontEnd" target="_blank">Frontend Repository</a></p>
<p>Feel free to explore and contribute to the frontend codebase for a complete understanding of the POS system.</p>


<p>Wishing you the best of success in your coding endeavors!</p>
