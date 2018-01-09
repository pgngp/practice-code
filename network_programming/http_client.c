#include <netinet/in.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/socket.h>

int main()
{
	// Create client socket
	int client_socket = socket(AF_INET, SOCK_STREAM, 0);
	
	// Create server address
	struct sockaddr_in server_address;
	server_address.sin_family = AF_INET;
	server_address.sin_addr.s_addr = INADDR_ANY;
	server_address.sin_port = htons(10001);
	
	// Connect to server socket
	if (connect(client_socket, (struct sockaddr *) &server_address, sizeof(server_address)) != 0) {
		perror("Error: Could not connect to server socket.\n");
		exit(EXIT_FAILURE);
	}
	
	// Send request to server
	char request[] = "GET / HTTP1.1/r/n/r/n";
	if (send(client_socket, request, sizeof(request), 0) < 0) {
		perror("Error: Could not send request to server.\n");
		exit(EXIT_FAILURE);
	}
	
	// Get response from server
	char response[1000];
	if (recv(client_socket, &response, sizeof(response), 0) < 0) {
		perror("Error: Could not get response from server.\n");
		exit(EXIT_FAILURE);
	}
	
	printf("Server response: %s\n", response);
	
	return 0;
}