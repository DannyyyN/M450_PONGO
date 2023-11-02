import { defineConfig } from "cypress";

export default defineConfig({
  e2e: {
    setupNodeEvents(on, config) {
      // Implement custom Node event listeners here
      on("before:run", (details) => {
        // Add custom logic to run before the tests start
      });

      on("after:run", (results) => {
        // Add custom logic to run after the tests have completed
      });
    },
  },
});
