# Task1

## P1

![屏幕截图 2024-04-20 181912](C:\Users\god\Pictures\Screenshots\屏幕截图 2024-04-20 181912.png)

Let's  set 𝑥~1~ = 𝑡, so 𝑥~2~ = 1 − 𝑡 𝑤ℎ𝑒𝑟𝑒 0 ≤ 𝑡 ≤ 1, so minimize 𝑥~1~ + 𝑥~2~= 1.

## P2

![屏幕截图 2024-04-20 181958](C:\Users\god\Pictures\Screenshots\屏幕截图 2024-04-20 181958.png)

Let's add the first and third constraint, we can get  𝑥~1~ + 𝑥~2~ + 𝑥~3~ + 𝑥~4~ = 1, so minimum 𝑥~1~ + 𝑥~2~ + 𝑥~3~ + 𝑥~4~ = 1.

# Task2

 **Three LP solvers**: **GLPK (GNU Linear Programming Kit),** **Gurobi, PuLP**



## P1 Results:

|        | x1   | x2   | **Object function** |
| ------ | ---- | ---- | ------------------- |
| GLPK   | 1.0  | 0.0  | 1.0                 |
| Gurobi | 1.0  | 0.0  | 1.0                 |
| Pulp   | 1.0  | 0.0  | 1.0                 |



## P2 Results:

|        | x1   | x2   | x3   | x4   | **Object function** |
| ------ | ---- | ---- | ---- | ---- | ------------------- |
| GLPK   | 0.0  | 1.0  | 0.0  | 1.0  | 2.0                 |
| Gurobi | 1.0  | 0.0  | 1.0  | 0.0  | 2.0                 |
| Pulp   | 0.0  | 1.0  | 0.0  | 1.0  | 2.0                 |





# Task3

![屏幕截图 2024-04-20 183000](C:\Users\god\Pictures\Screenshots\屏幕截图 2024-04-20 183000.png)

**Set boundary = 1; Set element = (element<boundary); constraint is satisfied: Set element = (element<boundary) boundary=0.01**

|              | **(i)** | **(ii)** | **(iii)** | **(iv)** |
| ------------ | ------- | -------- | --------- | -------- |
| Running time | 0.075ms | 256ms    | 3.15ms    | 542ms    |
| Object value | 1667    | 2953     | 2987      | 3093     |





# Task4

![屏幕截图 2024-04-20 183619](C:\Users\god\Pictures\Screenshots\屏幕截图 2024-04-20 183619.png)

### 200-item results:

|              | **(i)** | **(ii)** | **(iii)** | **(iv)** |
| ------------ | ------- | -------- | --------- | -------- |
| Running time | 0.78ms  | 563ms    | 7.2ms     | 1029ms   |
| Object value | 4190    | 6248     | 6260      | 6341     |



### 400-item results:

|              | **(i)** | **(ii)** | **(iii)** | **(iv)** |
| ------------ | ------- | -------- | --------- | -------- |
| Running time | 2.6ms   | 1125ms   | 20.3ms    | 120456ms |
| Object value | 9841    | 12918    | 12929     | 12936    |

For using an integer LP (ILP) solver, the running time increase very fast when the scale of the problem grows, while using an 

LP solver increase nearly linearly.





# Task5

![屏幕截图 2024-04-20 184112](C:\Users\god\Pictures\Screenshots\屏幕截图 2024-04-20 184112.png)

![屏幕截图 2024-04-20 190150](C:\Users\god\Pictures\Screenshots\屏幕截图 2024-04-20 190150.png)

```
learning_rates = [0.03, 0.3, 0.9]
```

When learning rate is too small, it will take a long time to search at beginning. And if learning rate is too large, it will cause shaking. Therefore, select learning rate with a median value like 0.3 is reasonable .