#include <stdio.h>
#include <stdlib.h>

#include <sys/socket.h>
#include <netinet/in.h>

int main()
{
    char data[100] = "Hello World!";
    char buffer[1000] = {0};

    // Create a socket
		int client_socket;
    client_socket = socket(AF_INET, SOCK_STREAM, 0);
		if (client_socket < 0) {
			printf("Error creating socket\n");
		  return -1;
		}

		// Setup address
		struct sockaddr_in server_address;
		server_address.sin_family = AF_INET;
		server_address.sin_addr.s_addr = INADDR_ANY;
		server_address.sin_port = htons(10001);

		// Connect to server
		if (connect(client_socket, (struct sockaddr *) &server_address, sizeof(server_address))) {
			printf("Error: connection failed\n");
		  return -1;
		}

		// Send request
		send(client_socket, buffer, sizeof(buffer), 0);
		printf("Sent request...\n");
		recv(client_socket, &buffer, sizeof(buffer), 0);
		printf("Server response: %s\n", buffer);

		// Close socket
		// close(client_socket);

    return 0;
}