const { defineConfig } = require("cypress");
//const { Test } = require("mocha");

async function setupNodeEvents(on, config) {
  // implement node event listeners here
  return config;
}

module.exports = defineConfig({
  e2e: {
    setupNodeEvents,
    specPattern:"cypress/CWAPITesting/Test/*.js"
  },
});
