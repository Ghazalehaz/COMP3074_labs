
import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

export default function App() {
  return (
    <View style={styles.container}>
      <View style={styles.card}>
        <Text style={styles.name}>
          Ghazaleh Azimikorf
        </Text>

        <View style={styles.divider} />

        <Text style={styles.label}>
          Student ID
        </Text>

        <Text style={styles.studentId}>
          101564963
        </Text>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#FFF1F2',
    justifyContent: 'center',
    alignItems: 'center',
    padding: 24,
  },

  card: {
    width: '95%',
    backgroundColor: '#FFFFFF',
    borderRadius: 20,
    padding: 30,
    alignItems: 'center',
    borderWidth: 1,
    borderColor: '#F4CBD0',
    elevation: 4,
    shadowColor: '#000000',
    shadowOffset: {
      width: 0,
      height: 2,
    },
    shadowOpacity: 0.1,
    shadowRadius: 6,
  },

  name: {
    fontSize: 32,
    fontWeight: 'bold',
    color: '#9B1025',
    textAlign: 'center',
  },

  divider: {
    width: 70,
    height: 3,
    backgroundColor: '#C90012',
    borderRadius: 5,
    marginVertical: 20,
  },

  label: {
    fontSize: 15,
    color: '#777777',
    marginBottom: 8,
  },

  studentId: {
    fontSize: 22,
    fontWeight: '600',
    color: '#191919',
    textAlign: 'center',
  },
});
