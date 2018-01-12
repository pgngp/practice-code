#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/un.h>
#include <sys/socket.h>
#include <sys/types.h>

int main()
{
	char server_message[1024] = "Hello from server!";
	char client_message[1024];
	
	// Create server socket
	int server_socket = socket(AF_UNIX, SOCK_STREAM, 0);
	if (socket < 0) {
		perror("Error: Could not create server socket.\n");
		exit(EXIT_FAILURE);
	}
	
	// Bind the server socket to a file
	struct sockaddr_un server_address;
	server_address.sun_family = AF_UNIX;
	strcpy(server_address.sun_path, "server_socket2");
	if (bind(server_socket, (struct sockaddr *) &server_address, sizeof(server_address)) < 0) {
		perror("Error: Could not bind server socket.\n");
		exit(EXIT_FAILURE);
	}
	
	// Listen to incoming connections
	if (listen(server_socket, 2) < 0) {
		perror("Error: Could not listen for new connections.\n");
		exit(EXIT_FAILURE);
	}
	
	// Accept incoming connections, send/receive data
	int client_socket;
	while (1) {
		// Accept incoming connections
		if ((client_socket = accept(server_socket, NULL, NULL)) < 0) {
			perror("Error: Could not accept incoming request.\n");
			exit(EXIT_FAILURE);
		}
		
		// Send server message to client
		if (send(server_socket, server_message, sizeof(server_message), 0) < 0) {
			perror("Error: Could not send server message to client.\n");
			exit(EXIT_FAILURE);
		}
		
		// Receive message from client
		if (recv(server_socket, &client_message, sizeof(client_message), 0) < 0) {
			perror("Error: Could not receive client message.\n");
			exit(EXIT_FAILURE);
		}
		printf("Client message: %s\n", client_message);
		close(client_socket);
	}
	
	// Close server socket and unlink socket path
	close(server_socket);
	unlink("server_socket2");
	
	return 0;
}