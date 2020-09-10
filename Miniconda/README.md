# Miniconda

## 【解决】安装conda后取消命令行前出现的base，取消每次启动自动激活conda的基础环境

[安装conda后取消命令行前出现的base，取消每次启动自动激活conda的基础环境](https://blog.csdn.net/u014734886/article/details/90718719)

## conda虚拟环境

### 安装虚拟环境

参考：[用conda创建python虚拟环境](https://blog.csdn.net/lyy14011305/article/details/59500819)

1. 首先在所在系统中安装conda。可以打开命令行输入conda -V检验是否安装以及当前conda的版本。

2. conda常用的命令。

- `conda list` 查看安装了哪些包。

- `conda env list` 或 `conda info -e` 查看当前存在哪些虚拟环境

- `conda update conda` 检查更新当前conda

3. 创建python虚拟环境。

     使用 `conda create -n your_env_name python=X.X（2.7、3.6等)` 命令创建python版本为X.X、名字为your_env_name的虚拟环境。your_env_name文件可以在Anaconda安装目录envs文件下找到。

4. 使用激活(或切换不同python版本)的虚拟环境。

    打开命令行输入`python --version`可以检查当前python的版本。

    使用如下命令即可 激活你的虚拟环境(即将python的版本改变)。

    Mac: `conda activate your_env_name`

   这是再使用`python --version`可以检查当前python版本是否为想要的。

5. 对虚拟环境中安装额外的包。

    使用命令`conda install -n your_env_name [package]`即可安装package到your_env_name中

6. 关闭虚拟环境(即从当前环境退出返回使用PATH环境中的默认python版本)。

   使用如下命令即可。

   Mac: `conda deactivate`

7. 删除虚拟环境。

   使用命令`conda remove -n your_env_name(虚拟环境名称) --all`， 即可删除。

8. 删除环境中的某个包。

   使用命令`conda remove --name your_env_name  package_name` 即可。

