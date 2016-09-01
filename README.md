#mjPreferences
=====
A small library containing a wrapper/helper for the shared preferences of Android.

[ ![Download](https://api.bintray.com/packages/blackdole/maven/mjpreferences/images/download.svg) ](https://bintray.com/blackdole/maven/mjpreferences/_latestVersion)
[![API](https://img.shields.io/badge/API-9%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=9)
[![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)

###Maven
```
<dependency>
  <groupId>net.djcp</groupId>
  <artifactId>mjpreferences</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>
```

###Gradle
```groovy
dependencies { 
    compile 'net.djcp:mjpreferences:1.0.1'
}
```

###Usage
With this library you can initialize the shared preference inside the onCreate of the Application class of your app.
```java
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        new Preferences.Builder()
                .setContext(this)
                .setPreferencesName("mjPreferences-Sample")
                .build();
    }
}
```
```java
public class MainActivity extends AppCompatActivity {

    Button mButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Preferences.putInt("Test", 200);
        mButton1 = (Button) findViewById(R.id.button1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Test -> " + Preferences.getInt("Test", 0), Toast.LENGTH_LONG).show();
            }
        });
    }
}
```

###License
    
    Copyright (c) 2016 Black}{ole
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
