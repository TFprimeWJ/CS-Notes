# Stanford CS 144

视频（b站）：https://www.bilibili.com/video/BV137411Z7LR

stanford官网：https://cs144.github.io/

## 1-2 The four layer of Internet model

网络四层结构

- Application
- Transport
- Network
- Link

## 1-3 The IP Service Model

IP的设计理念：simple，dumb，minimal

IP提供的服务特点，下面的特点是基于上面的理念：

- Datagram
- Unreliable
- Best-effort
- Connectionless

实际上，网络中的任何一次包的传输都要使用IP协议，所以将IP协议做到非常整洁

TTL是记录一个packet在网络中的router跳转次数的一个量。比如，TTL从128开始，每经过一个router就减一，所以我们可以通过看TTL的数值知道这个packet从source到destination一共经历了多少个router。TTL还有一个功能就是可以看出网络中是否出现packet looping forever的情况，如果一个packet的TTL减到了0，那么非常有可能这个packet正处在一个无限循环的路径中，这时网络就会把这个packet直接扔掉。

## 1-6 Layering Principle

[编译和链接的区别](https://blog.csdn.net/MONKEY_D_MENG/article/details/5651649?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param)