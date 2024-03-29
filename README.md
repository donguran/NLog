[![](https://jitpack.io/v/donguran/NLog.svg)](https://jitpack.io/#donguran/NLog)

# NLog
android Log , you can know linenum-ber, line location and error message

<br/>

#### settings.gradle(project)
```Gradle
dependencyResolutionManagement {
     repositories {
        maven { url 'https://jitpack.io'}     // or : maven(url = "https://jitpack.io")
    } 
}
```

<br/>

#### build.gradle(app)
```Gradle
dependencies {
    implementation 'com.github.donguran:NLog:1.1.3'
}
```
<br />

#### import
```kotlin
import com.donguran.nlog.NLog
```

<br />

#### possible LineBreak from "1.0.9" version <br />
`NLog.l(level: LogLevel, count: Int, shape: String)`
- simple LineBreak     <br/>
@param level : LogLevel Type VERBOSE, INFO, DEBUG, WARN, ERROR     <br/>
@param count : is linebreak shape counts     <br/>
@param shape : is nested strings     <br/>
```kotlin
NLog.l()
/*
[MainActivity.kt:15] ===========
*/
```

```kotlin
NLog.l(count=20, shape = "*")
/*
[MainActivity.kt:17] *********************
*/
```

  

<br/>
<br/>

#### LICENSE

```text
   Copyright 2023 Neander of donguran

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
