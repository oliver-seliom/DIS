const express = require('express');
const bodyParser = require('body-parser');

const app = express();
const PORT = 3009;

// Middleware to parse JSON requests
app.use(bodyParser.json());

const users = []; // An in-memory store for our users

// GET endpoint to retrieve all users
app.get('/users', (req, res) => {
    res.json(users);
});

// POST endpoint to create a new user
app.post('/users', (req, res) => {
    const newUser = req.body;
    users.push(newUser);
    res.status(201).json(newUser);
});

// GET 1 user by id
app.get('/users/:id', (req, res) => {
    const userId = parseInt(req.params.id, 10);
    const index = users.findIndex(user => user.id === userId);
    
    if (index !== -1) {
      res.json(users[index]);
    } else {
      res.status(404).send('User not found');
    }
});

// PUT endpoint to update a specific user by ID
app.put('/users/:id', (req, res) => {
    const userId = parseInt(req.params.id, 10);
    const updatedUser = req.body;
    
    const index = users.findIndex(user => user.id === userId);
    
    if (index !== -1) {
        users[index] = updatedUser;
        res.json(updatedUser);
    } else {
        res.status(404).send('User not found');
    }
});

// DELETE endpoint to remove a user by ID
app.delete('/users/:id', (req, res) => {
    const userId = parseInt(req.params.id, 10);
    const index = users.findIndex(user => user.id === userId);
    
    if (index !== -1) {
        users.splice(index, 1);
        res.status(204).send(); // No Content response
    } else {
        res.status(404).send('User not found');
    }
});

app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});
