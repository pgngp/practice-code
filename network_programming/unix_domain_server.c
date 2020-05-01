#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/un.h>
#include <sys/socket.h>
#include <sys/types.h>

int main()
{
	char server_message[1024] = "Hello from server!";
	
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
	printf("Listening for new connections...\n");
	
	while (1) {
		printf("\n");
		
		// Accept incoming connections
		int client_socket;
		if ((client_socket = accept(server_socket, NULL, NULL)) < 0) {
			perror("Error: Could not accept incoming request.\n");
			exit(EXIT_FAILURE);
		}
		printf("Accepted new client connection %d...\n", client_socket);
		
		// Send server message to client
		if (send(client_socket, server_message, strlen(server_message), 0) < 0) {
			perror("Error: Could not send server message to client.\n");
			exit(EXIT_FAILURE);
		}
		printf("Sent '%s' to client...\n", server_message);
		
		// Receive message from client
		char client_message[1024];
		while (recv(client_socket, &client_message, sizeof(client_message), 0) != 0) {
			printf("Received client message: %s\n", client_message);
		}
		close(client_socket);
}

	// Close server socket and unlink socket path
	close(server_socket);
	unlink("server_socket2");
	
	return 0;
}