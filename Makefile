# binary search program makefile
# Hussein Suleman
# 27 March 2017
JAVAC=/usr/bin/javac

.SUFFIXES: .java .class

BINDIR=bin
SRCDIR=src
DOCDIR=doc

${BINDIR}/:${BINDIR}/BinaryTreeNode.class ${BINDIR}/BinaryTree.class ${BINDIR}/LSBSTApp.class ${BINDIR}/AVLTree.class ${BINDIR}/LSAVLApp.class 

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES= BinaryTreeNode.class BinaryTree.class LSBSTApp.class AVLTree.class LSAVLApp.class

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)
default: $(CLASS_FILES)

clean:
	rm -f ${BINDIR}/*.class

run: 
	java -cp bin AVLTreeTest

docs: 
	javadoc -classpath ${BINDIR} -d ${DOCDIR} ${SRCDIR}/*.java

cleandocs:
	rm -f ${DOCDIR}/*
