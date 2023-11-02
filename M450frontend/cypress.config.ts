import { defineConfig } from "cypress";

export default defineConfig({
  e2e: {
    setupNodeEvents(on, config) {
      on("before:run", (details) => {
        // Add custom logic to run before the tests start
      });

      on("after:run", (results) => {
        // Add custom logic to run after the tests have completed
      });
    },
  },
  env: {
    BASE_URL: "http://localhost:3000",
    API_URL: "http://localhost:8080"
  }
});
