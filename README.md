# whatsTheFood-md

Repository untuk anak MD dari Bangkit Capstone Project dengan judul _What"s The Food?_

<details>
<summary>🧰Dependencies</summary>

```gradle
dependencies {

    implementation 'androidx.core:core-ktx:1.8.0'
    implementation 'androidx.appcompat:appcompat:1.4.2'
    implementation 'com.google.android.material:material:1.6.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0-rc01'
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.5.0-rc01'
    implementation 'androidx.navigation:navigation-fragment-ktx:2.4.2'
    implementation 'androidx.navigation:navigation-ui-ktx:2.4.2'
    implementation 'com.github.bumptech.glide:glide:4.13.2'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'

    implementation 'com.github.bumptech.glide:glide:4.11.0'
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation "com.squareup.retrofit2:converter-gson:2.9.0"
    implementation "com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.7"

    def camerax_version = "1.1.0-beta02"
    implementation "androidx.camera:camera-camera2:${camerax_version}"
    implementation "androidx.camera:camera-lifecycle:${camerax_version}"
    implementation "androidx.camera:camera-view:${camerax_version}"
```

</details>

<details>
<summary>API </summary>

- Base URL

  > `https://foodapp-5a4iggaygq-et.a.run.app`

- Endpoint
  `POST /predict`

  > body : form-data
  > key : image
  > value : file (jpg/png)

    </details>

<details>
<summary>Device Tested </summary>

- [x] Nexus 5X
- [x] Samsung A20
- [x] Xiaomi Mi A1 / Redmi 5X

</details>
