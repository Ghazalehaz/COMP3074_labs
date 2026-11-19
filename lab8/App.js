
import React, { useState, useEffect } from 'react';
import {
  View,
  Text,
  FlatList,
  ScrollView,
  Pressable,
  ActivityIndicator,
  SafeAreaView,
  StyleSheet,
} from 'react-native';

// Display each user in the list
function UserItem({ user, onPress }) {
  return (
    <Pressable style={styles.card} onPress={onPress}>
      <Text style={styles.userName}>{user.name}</Text>
      <Text style={styles.userEmail}>{user.email}</Text>
    </Pressable>
  );
}

export default function App() {
  const [users, setUsers] = useState([]);
  const [selectedUser, setSelectedUser] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  // Get users from the API
  useEffect(() => {
    const loadUsers = async () => {
      try {
        const response = await fetch(
          'https://jsonplaceholder.typicode.com/users'
        );

        if (!response.ok) {
          throw new Error('Failed to load users');
        }

        const data = await response.json();
        setUsers(data);
      } catch (err) {
        setError('Unable to load users.');
      } finally {
        setLoading(false);
      }
    };

    loadUsers();
  }, []);

  // Loading screen
  if (loading) {
    return (
      <View style={styles.center}>
        <ActivityIndicator size="large" color="#C90012" />
        <Text>Loading users...</Text>
      </View>
    );
  }

  // Error screen
  if (error) {
    return (
      <View style={styles.center}>
        <Text style={styles.error}>{error}</Text>
      </View>
    );
  }

  // Main user list
  if (selectedUser === null) {
    return (
      <SafeAreaView style={styles.container}>
        <Text style={styles.title}>Users</Text>

        <Text style={styles.subtitle}>
          Select a user to view their information
        </Text>

        <FlatList
          data={users}
          keyExtractor={(item) => item.id.toString()}
          renderItem={({ item }) => (
            <UserItem
              user={item}
              onPress={() => setSelectedUser(item)}
            />
          )}
        />
      </SafeAreaView>
    );
  }

  // User details screen
  return (
    <SafeAreaView style={styles.container}>
      <ScrollView>

        <Pressable
          style={styles.button}
          onPress={() => setSelectedUser(null)}
        >
          <Text style={styles.buttonText}>
            Back to Users
          </Text>
        </Pressable>

        <Text style={styles.title}>User Details</Text>

        <View style={styles.card}>
          <Text style={styles.sectionTitle}>
            Personal Information
          </Text>

          <Text>ID: {selectedUser.id}</Text>
          <Text>Name: {selectedUser.name}</Text>
          <Text>Username: {selectedUser.username}</Text>
          <Text>Email: {selectedUser.email}</Text>
          <Text>Phone: {selectedUser.phone}</Text>
          <Text>Website: {selectedUser.website}</Text>
        </View>

        <View style={styles.card}>
          <Text style={styles.sectionTitle}>
            Address
          </Text>

          <Text>
            Street: {selectedUser.address.street}
          </Text>
          <Text>
            Suite: {selectedUser.address.suite}
          </Text>
          <Text>
            City: {selectedUser.address.city}
          </Text>
          <Text>
            Zip Code: {selectedUser.address.zipcode}
          </Text>
          <Text>
            Latitude: {selectedUser.address.geo.lat}
          </Text>
          <Text>
            Longitude: {selectedUser.address.geo.lng}
          </Text>
        </View>

        <View style={styles.card}>
          <Text style={styles.sectionTitle}>
            Company
          </Text>

          <Text>
            Name: {selectedUser.company.name}
          </Text>
          <Text>
            Catch Phrase: {selectedUser.company.catchPhrase}
          </Text>
          <Text>
            Business: {selectedUser.company.bs}
          </Text>
        </View>

      </ScrollView>
    </SafeAreaView>
  );
}

// App styles
const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#F8F9FC',
    padding: 20,
    paddingTop: 45,
  },

  title: {
    fontSize: 28,
    fontWeight: 'bold',
    color: '#C90012',
    marginBottom: 10,
  },

  subtitle: {
    fontSize: 14,
    color: '#777777',
    marginBottom: 20,
  },

  card: {
    backgroundColor: '#FFFFFF',
    padding: 18,
    borderRadius: 12,
    marginBottom: 12,
    gap: 8,
  },

  userName: {
    fontSize: 18,
    fontWeight: 'bold',
    color: '#222222',
  },

  userEmail: {
    fontSize: 14,
    color: '#777777',
  },

  sectionTitle: {
    fontSize: 19,
    fontWeight: 'bold',
    color: '#C90012',
    marginBottom: 10,
  },

  button: {
    backgroundColor: '#C90012',
    padding: 14,
    borderRadius: 10,
    marginBottom: 20,
    alignItems: 'center',
  },

  buttonText: {
    color: '#FFFFFF',
    fontWeight: 'bold',
  },

  center: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    gap: 10,
  },

  error: {
    color: '#C90012',
    fontSize: 16,
  },
});
