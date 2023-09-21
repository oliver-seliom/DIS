# Git Cheatsheet: Alice and Bob's Collaboration

## 1. Setting up
**Initialize and Push by Alice**: Alice and Bob both want to work on a project. Alice creates a new repository.

```bash
# Alice creates a new project
mkdir my_project
cd my_project
# ... Alice creates here all the relevant project files

# Alice initializes the local repository
git init
```

Since they are going to be working together, Alice pushes the repository to Github. To this she first creates a new project on github and grabs its URL.

```bash
git remote add origin https://github.com/alice/my_project.git

git add .
git commit -m "Initial commit"
git push -u origin master
```

Bob clones the repository to start contributing.

```bash
git clone https://github.com/alice/my_project.git
cd my_project
```

## 2. Regular development flow

Alice and Bob always pull the latest changes before starting any new work.

```bash
git pull
```

Alice is currently on the main branch. 

```bash
git checkout master
git pull
```

She decides to work on a new feature, so see creates a new branch off main to not interfere with any ongoing work:

```bash
git branch feature/new-feature
git checkout feature/new-feature

# This is a shortcut for the previous 2 commands, which creates a new branch and checks it out
git checkout -b feature/new-feature
```

After doing some work, Alice adds a commit to this branch.
```bash
git add .
git commit -m "Updated some code"
```

When she is done adding commits, she pushes her changes to the remote repository on github.
```bash
git push
```

## 3. Review and approval

Alice and Bob have decided that they should only merge into main after the other has properly reviewed the others code. 

Bob needs to review the `feature/new-feature` branch that Alice created. To do this, Alice creates a **pull request** on Github and adds Bob as a reviewer.

**NOTE**: A pull request (PR) is a request in Github to merge a specific branch into another one. By default, we request to merge into master, since it has been agreed to be the source of truth. 

Bob takes a look at all the file changes in the PR and confirms it all looks good, so he marks the PR as approved.

Alice then clicks on **Merge pull request** on Github.

Now, either Bob or Alice want to work on yet a new feature.
```bash
git checkout master
git pull
# They are pulling the latest master from Github, which will include the changes that were merged from Alice's PR
```
