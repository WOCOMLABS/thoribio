## Things useful in Windows 10/11 Pro 

Fresh install, a shell script would be nice.  but I perform this ceremony every few months.    

## install [Power shell 7+](https://docs.microsoft.com/en-us/powershell/scripting/whats-new/migrating-from-windows-powershell-51-to-powershell-7?view=powershell-7.2)

search for that place that says Deploy PowerShell using the [download MSI package](https://docs.microsoft.com/en-us/powershell/scripting/install/installing-powershell-on-windows?view=powershell-7.2#msi)

##install wsl2,  A.K.A. windows subsystem for linux

From PS7 

```shell
wsl --install 
```

check version

```shell
wsl -l -v 
```

Once powershell 7+ is installed open an admin session  instructions should be there [Chocolatey](https://chocolatey.org/install)

You might "wanna" run this, but also you might "wanna" hold your horses and investigate what the thing does, please do not run any shell 
script you find in stack overflow or.   

```shell
Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
```

[handy chocolatey stuff](https://docs.chocolatey.org/en-us/choco/commands/)

use chocolatey to install our tools if you don't have these already 

[vscode](https://code.visualstudio.com/)
```shell
choco install vscode 
```
choco list jdk
choco info jdk11 
```shell
choco install openjdk11
```
verify your java version with 

```shell
java --version
```

use the GUI software see what's in there 
```shell
choco install chocolateygui
```

By the time I'm writing this the latest gradle in chocolatey was 7.3.3  
but 7.4 was release da few weeks back.

```shell
choco list gradle
```

Just use the latest (you'll be fine).

For this platform project (Thoribio Framework ) I was waiting to have kotlin 1.5.+ bundled with gradle 
which includes 
+ sealed interfaces
+ value classes 
+ the ability to return a Result<T> ( I think this was not available in 1.4.ish)

And something else that i can't recall now .
check [the what's new](https://kotlinlang.org/docs/whatsnew15.html) from the official documentation.

```
choco install gradle
```

```shell
gradle --version
```
want to have git?

```shell
choco install git
```

Use the [jetbrains tool box](https://www.jetbrains.com/lp/toolbox) and install intellij ultimate|community edition.

######Sometimes jetbrains have nice deals for students or teachers n_n.  

```shell
choco install jetbrainstoolbox 
```
