# Quarkus

# Installation
You have to install GraalVM
https://github.com/oracle/graal/releases

I choose GraalVM Community Edition 1.0 RC14

Next you have to export GRAALVM_HOME system variable in your .bashrc
export GRAALVM_HOME=$HOME/baptiste/Resources/GraalVm/latest

mvn package -Pnative

_________________________________
#### Under Fedora system

[baptiste@DESKTOP GraalVm]$ uname -a
Linux DESKTOP 4.20.16-200.fc29.x86_64 #1 SMP Thu Mar 14 15:10:22 UTC 2019 x86_64 x86_64 x86_64 GNU/Linux

When you will try to launch:
mvn package -Pnative

you will get an error as zlib is missing for c++ compilation.

To correct that, you can execute the following command:

sudo dnf install zlib-devel

