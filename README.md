
# react-native-my-native-library

## Getting started

`$ npm install react-native-my-native-library --save`

### Mostly automatic installation

`$ react-native link react-native-my-native-library`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-my-native-library` and add `RNMyNativeLibrary.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNMyNativeLibrary.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import org.shadow.upnpdiscovery.RNMyNativeLibraryPackage;` to the imports at the top of the file
  - Add `new RNMyNativeLibraryPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-my-native-library'
  	project(':react-native-my-native-library').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-my-native-library/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-my-native-library')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNMyNativeLibrary.sln` in `node_modules/react-native-my-native-library/windows/RNMyNativeLibrary.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using My.Native.Library.RNMyNativeLibrary;` to the usings at the top of the file
  - Add `new RNMyNativeLibraryPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNMyNativeLibrary from 'react-native-my-native-library';

// TODO: What to do with the module?
RNMyNativeLibrary;
```
  