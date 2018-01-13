#include <sys/socket.h>
#include <sys/types.h>
#include <sys/un.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
	// Create client socket
	int client_socket = socket(AF_UNIX, SOCK_STREAM, 0);
	if (client_socket < 0) {
		perror("Error: Could not create client socket.\n");
		exit(1);
	}
	
	// Create server address
	struct sockaddr_un server_address;
	server_address.sun_family = AF_UNIX;
	strcpy(server_address.sun_path, "server_socket2");
	
	// Connect to server socket
	if (connect(client_socket, (struct sockaddr *) &server_address, sizeof(server_address)) < 0) {
		perror("Error: Could not connect client socket to server socket.");
		close(client_socket);
		exit(1);
	}
	
	// Receive message from server
	char server_message[1024];
	if (recv(client_socket, server_message, sizeof(server_message), 0) < 0) {
		perror("Error: Could not receive message from server.\n");
		close(client_socket);
		exit(1);
	}
	printf("Server message: %s\n", server_message);
	
	// Ask user for input
	char client_message[1024];
	while (scanf("%s", client_message)) {
		// Send message to server
		if (send(client_socket, client_message, sizeof(client_message), 0) < 0) {
			perror("Error: Could not send message to server.\n");
			close(client_socket);
			exit(1);
		}
	}
	
	close(client_socket);
	
	return 0;
}