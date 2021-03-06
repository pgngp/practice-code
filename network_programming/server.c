#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <sys/types.h>

#include <netinet/in.h>

int main()
{
	char server_message[256] = "Hi, this is the server";
	char buffer[1000] = {};

	// Create server socket
	int server_socket = socket(AF_INET, SOCK_STREAM, 0);
	if (server_socket < 0) {
		perror("Error: Could not create a socket\n");
		exit(EXIT_FAILURE);
	}

	// Define server address
	struct sockaddr_in server_address;
	server_address.sin_family = AF_INET;
	server_address.sin_port = htons(10001);
	server_address.sin_addr.s_addr = INADDR_ANY;

	// Bind socket to IP address and port
	if (bind(server_socket, (struct sockaddr *) &server_address, sizeof(server_address)) < 0) {
		perror("Error: Could not bind socket\n");
		exit(EXIT_FAILURE);
	}

	// Listen for connections
	if (listen(server_socket, 10) < 0) {
		perror("Error: Could not listen for connections\n");
		exit(EXIT_FAILURE);
	}
	printf("Listening...\n");

	int client_socket;
	if ((client_socket = accept(server_socket, NULL, NULL)) < 0) {
		perror("Error: Could not accept connection\n");
		exit(EXIT_FAILURE);
	}
	printf("Client connection accepted...\n");
	
	// Receive messages from client and send client messages
	while (recv(client_socket, &buffer, sizeof(buffer), 0) != 0) {
		printf("Client request: %s\n", buffer);
		strcpy(server_message, buffer);
		strcat(server_message, " back to you");
		printf("Server response: %s\n", server_message);
		send(client_socket, server_message, sizeof(server_message), 0);
	}

	return 0;	
}