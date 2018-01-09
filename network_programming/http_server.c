#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>

int main()
{
	char server_response[1000] = "HTTP/1.1 200 OK\r\n\r\n<html><body>hello world!</body></html>";
	char client_request[1000];
	
	// Create a socket
	int server_socket = socket(AF_INET, SOCK_STREAM, 0);
	
	// Define server address
	struct sockaddr_in server_address;
	server_address.sin_family = AF_INET;
	server_address.sin_addr.s_addr = INADDR_ANY;
	server_address.sin_port = htons(10001);
	
	// Bind socket to IP address
	if (bind(server_socket, (struct sockaddr *) &server_address, sizeof(server_address)) < 0) {
		perror("Error: Could not bind socket to address.\n");
		exit(EXIT_FAILURE);
	}
	
	// Listen for connections on socket
	if (listen(server_socket, 0) < 0) {
		perror("Error: Could not listen for client connections.\n");
		exit(EXIT_FAILURE);
	}
	
	// Accept client requests and send response
	int client_socket;
	char requested_page[100];
	while (1) {
		// Accept client connection
		if ((client_socket = accept(server_socket, NULL, NULL)) < 0) {
			perror("Error: Could not accept client connection.");
			exit(EXIT_FAILURE);
		}
		
		// Receive request from client
		if (recv(client_socket, &client_request, sizeof(client_request), 0) < 0) {
			perror("Error: Could not receive client request.\n");
			exit(EXIT_FAILURE);
		}
		
		// Extract requested page
		sscanf(client_request, "%*s %s %*s", requested_page);
		printf("Client request: %s\n", client_request);
		printf("Requested page: %s\n", requested_page);
		if (strcmp(requested_page, "/") != 0) {
			printf("Invalid requested page: '%s'\n", requested_page);
			continue;
		}
		
		// Send response to client
		if (send(client_socket, server_response, sizeof(server_response), 0) < 0) {
			perror("Error: Could not send HTTP response.\n");
			exit(EXIT_FAILURE);
		}
	}
	
	return 0;
}