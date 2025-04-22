To run this progran:
With GUI:
  1. Navigate to GardenApplication.java
  2. run program
  3. Select plant from dropdown bar
  4. Press add to add the plant to the garden
  5. After all desired plants are added, press the Start button
  6. To stop the simulation, press the Stop button

Without GUI:
  1. Create a new GardenSimulationAPI()
  2. Call getPlants() and store the data
  3. Call gardenSimulationAPI.initialize()
  4. Make code for events - rain(), temperature(), parasite()
  5. After desired events have happened, call getStatus()

After program is finished, open garden.log to view logs.
