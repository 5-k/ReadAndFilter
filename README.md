# ReadAndFilter

ReadAndFilter

sh execute.sh   inputFilePath   inputArrayFilePath

Example

sh execute.sh  C:\\Work\file.txt  C:\\Work\inputArrayFile.txt

#Input Array File Example
 
-cm_tgl mda, -debug_access, -file, -full64

#Input File Example
 
-cm_tgl mda @ -cpp, -debug_access
-cpp @ -cm_tgl mda, -full64
-debug_access @ -cm_tgl mda, -file

