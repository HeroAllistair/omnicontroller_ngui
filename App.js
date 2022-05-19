import React, { Component } from 'react';
import { StatusBar } from 'expo-status-bar';
import { ImageBackground, StyleSheet, Button, Text, View, TouchableOpacity, TouchableWithoutFeedback, PermissionsAndroid } from 'react-native';
import { KorolJoystick } from "korol-joystick";
import { NavigationContainer, StackActions } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
/*import { GestureHandlerRootView, PanGestureHandler,  PanGestureHandlerGestureEvent } from 'react-native-gesture-handler';
import Animated, {
  useAnimatedGestureHandler,
  useAnimatedStyle,
  useSharedValue,
  withSpring,
} from "react-native-reanimated";*/

const image = { uri: 'https://wallpapercave.com/wp/wp1979062.jpg'};

const Stack = createNativeStackNavigator();

const MyStack = () => {
  return(
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen 
          name='Home'
          component={HomeScreen}
          options={{
            title: 'NGUI Project - OmniController',
            headerStyle: {
              backgroundColor: '#f4511e',
            },
            headerTintColor: '#fff',
            headerTitleStyle: {
              fontWeight: 'bold',
            },
          }}
        />
        <Stack.Screen
          name='Gamepad'
          component={GamePad}
        />
        <Stack.Screen
          name='Touchpad'
          component={Touchpad}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
};



const HomeScreen = ({navigation}) => {

  const gamepadClickedHandler = () => {
    navigation.navigate('Gamepad')
    // do something
  };

  const touchpadClickedHandler = () => {
    navigation.navigate('Touchpad')
    // do something
  };



  return (
    <>
      <ImageBackground source={image} resizeMode="cover" style={styles.image}>
      
        <View styles={styles.container}>

          <TouchableOpacity
            onPress={gamepadClickedHandler}
            style={styles.button}>
            <Text>Gamepad</Text>
          </TouchableOpacity>

          <TouchableOpacity
            onPress={touchpadClickedHandler}
            style={styles.button}>
            <Text>Touchpad</Text>
          </TouchableOpacity>

          <TouchableOpacity
            onPress={touchpadClickedHandler}
            style={styles.button}>
            <Text>Placeholder</Text>
          </TouchableOpacity>
      
        </View>
      </ImageBackground>
    </>
    
  );
};



const Touchpad = ({navigation}) => {

  /*
  const panGestureEvent = useAnimatedGestureHandler<PanGestureHandlerGestureEvent>(
    {
    onStart: (event) => {},
    onActive: (event) => {
      console.log(event.translationX);
    },
    onEnd: (event) => {},
    }
  );
  
  return (
    <View style={styles.container}>
      <PanGestureHandler>
        <Animated.View style={styles.pointer}/>
      </PanGestureHandler>
      <StatusBar style="auto" />

    </View>
  );*/

  var coordX = 0.0;
  var coordY = 0.0;

  const [x, onChangeCoordX] = React.useState(coordX)
  const [y, onChangeCoordY] = React.useState(coordY)

  const screenTouched = (evt) => {
    const newX = evt.nativeEvent.locationX;
    const newY = evt.nativeEvent.locationY;

    onChangeCoordX(newX);
    onChangeCoordY(newY);

    console.log(`x coord = ${newX}`)
    console.log(`y coord = ${newY}`)
  }


  return (
    <>
      <View style={styles.container}>
        <TouchableOpacity
          onPress={(evt) => screenTouched(evt)}
          style={styles.touchpad}
          activeOpacity={1}>
          <Text>Touch around here...</Text>
        </TouchableOpacity>
      </View>
      <View style={styles.smallcontainer}>
        <Text>X: {x} / Y: {y}</Text>
      </View>
    </>
  )
  
  
}



const GamePad = ({navigation}) => {

  /*
  if (Platform.OS === 'android') {
    // Calling the permission function
    const granted = PermissionsAndroid.request(
      PermissionsAndroid.PERMISSIONS.ACCESS_COARSE_LOCATION,
      {
        title: 'Bluetooth Permissions',
        message: 'We need access to bluetooth permissions',
      },
    );
    if (granted === PermissionsAndroid.RESULTS.GRANTED) {
      // Permission Granted
      console.log('granted');
    }
  }*/

  var up_button = 'Y';
  var mr_button = 'B';
  var ml_button = 'X';
  var down_button = 'A'

  const [up, onChangeUp] = React.useState(up_button)
  const [ml, onChangeML] = React.useState(ml_button)
  const [mr, onChangeMR] = React.useState(mr_button)
  const [down, onChangeDown] = React.useState(down_button)

  const [modeXbox, setMode] = React.useState(true);

  const switchMode = () => {

    if(modeXbox) {
      onChangeUp('X')
      onChangeML('Y')
      onChangeMR('A')
      onChangeDown('B')
      setMode(false)
    }
    else {
      onChangeUp('Y')
      onChangeML('X')
      onChangeMR('B')
      onChangeDown('A')
      setMode(true)
    }

  }




  //const DeviceManager = new BleManager();

  const buttonClickedHandler = () => {
    console.log('You have clicked a button!');
    // do something
  };


  return (
    <View style={styles.gamepad}>
      <View style={styles.joystick_container}>
        <KorolJoystick color="#06b6d4" radius={100} onMove={(data) => console.log(data)}></KorolJoystick>
        <StatusBar style="auto" />
      </View>


      <View style={styles.center_gamepad}>
        <View style={styles.action_buttons_zone}>
          <TouchableOpacity
            style={styles.action_buttons}>
            <Text>
              Select
            </Text>
          </TouchableOpacity>
          <TouchableOpacity
            style={styles.action_buttons}>
            <Text>
              Start
            </Text>
          </TouchableOpacity>
        </View>
        <TouchableOpacity
          style={styles.switch_button}
          onPress={switchMode}>
          <Text>
            Switch mode XBox: {modeXbox.toString()}
          </Text>
        </TouchableOpacity>
      </View>



      <View style={styles.button_container}>
        <View style={styles.top_button_container}>
          <TouchableOpacity
              onPress={buttonClickedHandler}
              style={styles.roundButton1}>
              <Text>{up}</Text>
          </TouchableOpacity>
        </View>
        <View style={styles.middle_button_container}>
        <TouchableOpacity
              onPress={buttonClickedHandler}
              style={styles.roundButton1}>
              <Text>{ml}</Text>
          </TouchableOpacity>
          <TouchableOpacity
              onPress={buttonClickedHandler}
              style={styles.roundButton1}>
              <Text>{mr}</Text>
          </TouchableOpacity>
        </View>
        <View style={styles.bottom_button_container}>
          
          <TouchableOpacity
              onPress={buttonClickedHandler}
              style={styles.roundButton1}>
              <Text>{down}</Text>
          </TouchableOpacity>
        </View>
      </View>
    </View>
  );
};

// -----------------------------------------------------

export default MyStack;





// -----------------------------------------------------

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    flexDirection: 'row',
    justifyContent: 'center',
  },
  image: {
    flex: 1,
    justifyContent: "center"
  },
  smallcontainer: {
    flex: 0.1,
    backgroundColor: '#eee',
    alignItems: 'center',
    flexDirection: 'row',
    justifyContent: 'center',
  },
  button: {
    width: '30%',
    height: '25%',
    justifyContent: 'center',
    alignItems: 'center',
    flexDirection: 'row',
    padding: 10,
    backgroundColor: 'teal',
    marginTop: '2%',
    marginLeft: '35%',
    borderRadius: 10,
  },
  touchpad: {
    width: '100%',
    height: '100%',
    justifyContent: 'center',
    alignItems: 'center',
    flexDirection: 'row',
    backgroundColor: '#fff',
  },
  gamepad: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    flexDirection: 'row',
    justifyContent: 'center',
  },
  center_gamepad: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    flexDirection: 'column',
    justifyContent: 'center',
  },
  switch_button: {
    width: '75%',
    height: '15%',
    justifyContent: 'center',
    alignItems: 'center',
    flexDirection: 'row',
    padding: 10,
    backgroundColor: 'salmon',
    borderRadius: 10,
  },
  action_buttons: {
    width: '25%',
    height: '15%',
    justifyContent: 'center',
    alignItems: 'center',
    flexDirection: 'row',
    padding: 10,
    backgroundColor: 'grey',
    borderRadius: 10,
    marginLeft: 3,
    marginRight: 3,
  },
  action_buttons_zone: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    flexDirection: 'row',
    justifyContent: 'center',
  },
  joystick_container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    flexDirection: 'row',
    justifyContent: 'center',
  },
  button_container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    flexDirection: 'column',
    justifyContent: 'center',
  },
  middle_button_container: {
    flex: 1,
    alignItems: 'center',
    flexDirection: 'row',
    justifyContent: 'space-evenly',
  },
  top_button_container: {
    flex: 3,
    alignItems: 'flex-end',
    flexDirection: 'row',
    justifyContent: 'center',
  },
  bottom_button_container: {
    flex: 3,
    alignItems: 'flex-start',
    flexDirection: 'row',
    justifyContent: 'center',
  },
  roundButton1: {
    width: 75,
    height: 75,
    justifyContent: 'center',
    alignItems: 'center',
    flexDirection: 'column',
    padding: 10,
    borderRadius: 100,
    backgroundColor: 'orange',
    marginLeft: 45,
  },
  pointer: {
    width: 50,
    height: 50,
    borderRadius: 10,
    backgroundColor: 'grey',
  }
});
