/**
 * Sample React Native App
 *
 * adapted from App.js generated by the following command:
 *
 * react-native init example
 *
 * https://github.com/facebook/react-native
 */

import React, { Component } from 'react';
import { Platform, StyleSheet, Text, View } from 'react-native';
import SvgaPlayerEx from 'react-native-svga-player-ex';

export default class App extends Component {
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>☆SvgaPlayerEx example☆</Text>
        <Text style={styles.instructions}>STATUS: loaded</Text>
        <Text style={styles.welcome}>☆☆☆</Text>
        <SvgaPlayerEx
            style={{width: 400, height: 400}}
            source={`http://jssdynamic.oss-cn-shenzhen.aliyuncs.com/%E8%B7%91%E8%BD%A6.svga`}
        />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});
