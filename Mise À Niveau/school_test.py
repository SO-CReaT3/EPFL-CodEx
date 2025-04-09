from matplotlib import pyplot as plt
import numpy as np

x_1 = np.linspace(0, 5, 10)
y_1 = x_1**2
plt.plot(x_1, y_1)
plt.title("Skibidi")
plt.xlabel("SHeed")
plt.ylabel("anakonda")
plt.show()

# ----------- numpy -----------

a = np.array([[1, 2, 3], [1, 2, 3], [2, 4, 5], [1, 2, 4]])
print(a.shape, a.ndim)  # (4, 3) 2 <-> dim(line), dim(col), ndim -> depth.
