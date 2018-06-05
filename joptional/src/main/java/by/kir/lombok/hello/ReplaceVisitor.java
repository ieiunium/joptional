package by.kir.lombok.hello;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree.JCAnnotation;
import com.sun.tools.javac.tree.JCTree.JCBlock;
import com.sun.tools.javac.tree.JCTree.JCClassDecl;
import com.sun.tools.javac.tree.JCTree.JCCompilationUnit;
import com.sun.tools.javac.tree.JCTree.JCFieldAccess;
import com.sun.tools.javac.tree.JCTree.JCMethodDecl;
import com.sun.tools.javac.tree.JCTree.JCMethodInvocation;
import com.sun.tools.javac.tree.JCTree.JCVariableDecl;
import lombok.javac.JavacASTVisitor;
import lombok.javac.JavacNode;

import java.util.ArrayList;
import java.util.List;

public class ReplaceVisitor implements JavacASTVisitor {

    @Override
    public void visitCompilationUnit(JavacNode top, JCCompilationUnit unit) {

    }

    @Override
    public void endVisitCompilationUnit(JavacNode top, JCCompilationUnit unit) {

    }

    @Override
    public void visitType(JavacNode typeNode, JCClassDecl type) {

    }

    @Override
    public void visitAnnotationOnType(JCClassDecl type, JavacNode annotationNode, JCAnnotation annotation) {

    }

    @Override
    public void endVisitType(JavacNode typeNode, JCClassDecl type) {

    }

    @Override
    public void visitField(JavacNode fieldNode, JCVariableDecl field) {

    }

    @Override
    public void visitAnnotationOnField(JCVariableDecl field, JavacNode annotationNode, JCAnnotation annotation) {

    }

    @Override
    public void endVisitField(JavacNode fieldNode, JCVariableDecl field) {

    }

    @Override
    public void visitInitializer(JavacNode initializerNode, JCBlock initializer) {

    }

    @Override
    public void endVisitInitializer(JavacNode initializerNode, JCBlock initializer) {

    }

    @Override
    public void visitMethod(JavacNode methodNode, JCMethodDecl method) {

    }

    @Override
    public void visitAnnotationOnMethod(JCMethodDecl method, JavacNode annotationNode, JCAnnotation annotation) {

    }

    @Override
    public void endVisitMethod(JavacNode methodNode, JCMethodDecl method) {

    }

    @Override
    public void visitMethodArgument(JavacNode argumentNode, JCVariableDecl argument, JCMethodDecl method) {

    }

    @Override
    public void visitAnnotationOnMethodArgument(JCVariableDecl argument, JCMethodDecl method, JavacNode annotationNode,
                                                JCAnnotation annotation) {

    }

    @Override
    public void endVisitMethodArgument(JavacNode argumentNode, JCVariableDecl argument, JCMethodDecl method) {

    }

    @Override
    public void visitLocal(JavacNode localNode, JCVariableDecl local) {

    }

    @Override
    public void visitAnnotationOnLocal(JCVariableDecl local, JavacNode annotationNode, JCAnnotation annotation) {

    }

    @Override
    public void endVisitLocal(JavacNode localNode, JCVariableDecl local) {

    }

    private List<JCTree> statementList = new ArrayList<>();

    public List<JCTree> getStatementList() {
        return statementList;
    }

    @Override
    public void visitStatement(JavacNode statementNode, JCTree statement) {
        statementList.add((JCTree) statement.clone());
    }

    @Override
    public void endVisitStatement(JavacNode statementNode, JCTree statement) {

    }
}
