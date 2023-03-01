# Online Medical Store
## Description  
A centralized server of medicines is stored and multiple clients can access these services by booking and paying for these medicines.

## Technologies Used
* Java JDK
* CORBA

## Files compilation
#### IDL:
`
$ idlj -fall store.idl
`

#### Server:
`$ javac Server.java`
#### Client:
`$ javac Client.java`

## Start
#### ORB:
`$ tnameserv -ORBInitialPort 2000`

#### Server
`$ java Server -ORBInitialHost localhost -ORBInitialPort 2000`

#### Client
`$ java Client -ORBInitialHost localhost -ORBInitialPort 2000`


