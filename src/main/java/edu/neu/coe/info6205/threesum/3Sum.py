#!/usr/bin/env python
# coding: utf-8

# In[5]:


import matplotlib.pyplot as plt# Updated input with additional values for quadratic and quadrithmic times
N = [250, 500, 1000, 2000, 4000, 8000, 16000]
quadratic_time = [0.952, 1.559, 4.980, 16.224, 82.412, 426.437, 2081.723]
quadrithmic_time = [1.144, 2.797, 12.717, 66.574, 298.984, 1333.41, 5703.38]
cubic_time = [3.854, 23.179, 177.923, 1394.869, None, None, None]

# For cubic time, we create a filtered list that excludes None values for plotting
filtered_N_cubic = [N[i] for i in range(len(N)) if cubic_time[i] is not None]
filtered_cubic_time = [time for time in cubic_time if time is not None]

plt.figure(figsize=(10, 6))
plt.grid(True, linestyle='--', alpha=0.6)
plt.title('Comparision of Different 3Sum Algorithms')
plt.xlabel('n')
plt.ylabel('Time (ms)')


plt.plot(N, quadratic_time, marker='o', label='Quadratic')
plt.plot(N, quadrithmic_time, marker='o', label='Quadrithmic')

# Plotting filtered data for cubic time (only up to N=4000)
plt.plot(filtered_N_cubic, filtered_cubic_time, marker='o', label='Cubic (N<=4000)')

plt.legend()
plt.show()


# In[ ]:




