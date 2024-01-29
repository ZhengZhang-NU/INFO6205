#!/usr/bin/env python
# coding: utf-8

# In[4]:


import matplotlib.pyplot as plt

m_values = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]  
average_distances = [2.8077726766300395,3.8989854672208315,4.951910716793313,5.463053824463175, 6.213193138806146, 6.7825229832969365, 7.477372143437919,7.919369871477428, 8.56976904655805, 9.016204132336359]


plt.plot(m_values, average_distances, marker='o') 


plt.xlabel("Number of Steps (m)")
plt.ylabel("Average Distance (d)")

plt.grid(True)
plt.show()




# In[6]:


import matplotlib.pyplot as plt
import numpy as np

m_values = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
average_distances = [2.8077726766300395, 3.8989854672208315, 4.951910716793313, 5.463053824463175, 6.213193138806146, 6.7825229832969365, 7.477372143437919, 7.919369871477428, 8.56976904655805, 9.016204132336359]

# Perform a quadratic polynomial fit to the data
coefficients = np.polyfit(m_values, average_distances, 2)

polynomial = np.poly1d(coefficients)

# Generate a range of m values for plotting the fit curve
m_line = np.linspace(min(m_values), max(m_values), 100)
# Calculate d values for the fit curve

d_line = polynomial(m_line)


plt.plot(m_values, average_distances, 'o', label='Experimental data')
plt.plot(m_line, d_line, label='Quadratic fit')


plt.xlabel("Number of Steps (m)")
plt.ylabel("Average Distance (d)")
plt.legend()


plt.grid(True)
plt.show()


# In[ ]:




