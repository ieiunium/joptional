package by.kir.lombok.hello;

import com.sun.source.tree.Tree.Kind;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree.JCAnnotation;
import com.sun.tools.javac.tree.JCTree.JCBinary;
import com.sun.tools.javac.tree.JCTree.JCBlock;
import com.sun.tools.javac.tree.JCTree.JCClassDecl;
import com.sun.tools.javac.tree.JCTree.JCCompilationUnit;
import com.sun.tools.javac.tree.JCTree.JCConditional;
import com.sun.tools.javac.tree.JCTree.JCExpression;
import com.sun.tools.javac.tree.JCTree.JCIdent;
import com.sun.tools.javac.tree.JCTree.JCLiteral;
import com.sun.tools.javac.tree.JCTree.JCMethodDecl;
import com.sun.tools.javac.tree.JCTree.JCMethodInvocation;
import com.sun.tools.javac.tree.JCTree.JCVariableDecl;
import lombok.javac.JavacASTVisitor;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;
import lombok.javac.JavacTreeMaker.TreeTag;
import lombok.javac.JavacTreeMaker.TypeTag;

import java.util.List;
import java.util.stream.Collectors;

public class JopFinderVisitor implements JavacASTVisitor {

    @Override
    public void visitStatement(JavacNode statementNode, JCTree statement) {
        if (
            Kind.METHOD_INVOCATION.equals(statement.getKind()) && true
            ) {
            JCMethodInvocation declaration = (JCMethodInvocation) statementNode.get();
            if ("Jop.of".equals(declaration.getMethodSelect().toString())) {
                JavacTreeMaker treeMaker = statementNode.getTreeMaker();

                ReplaceVisitor replaceVisitor = new ReplaceVisitor();
                statementNode.traverse(replaceVisitor);
                List<JCTree> treeList = replaceVisitor
                    .getStatementList()
                    .stream()
                    .skip(3)
                    .filter(jcTree -> jcTree instanceof JCIdent || jcTree instanceof JCMethodInvocation)
                    .collect(Collectors.toList());

                JCTree result = null;

                for (int i = 1; i < treeList.size(); i++) {
                    if (result == null) {
                        result = conditionalWrap(treeMaker,(JCExpression)treeList.get(i),(JCExpression)treeList.get(i - 1));
                    } else {
                        result = conditionalWrap(treeMaker, (JCExpression)treeList.get(i), (JCExpression) result);
                    }
                }
                declaration.args = com.sun.tools.javac.util.List.of((JCExpression) result);
            }
        }
    }

    public static JCConditional conditionalWrap(JavacTreeMaker treeMaker, JCExpression exp) {

        final JCLiteral nullLiteral = getNullLiteral(treeMaker);
        JCBinary eq = treeMaker.Binary(TreeTag.treeTag("EQ"), exp, nullLiteral);
        return treeMaker.Conditional(eq, nullLiteral, exp);
    }

    public static JCConditional conditionalWrap(JavacTreeMaker treeMaker, JCExpression exp1, JCExpression exp2) {
        final JCLiteral nullLiteral = getNullLiteral(treeMaker);
        final JCBinary eq = treeMaker.Binary(TreeTag.treeTag("EQ"), exp1, nullLiteral);
        return treeMaker.Conditional(eq, nullLiteral, exp2);
    }

    public static JCLiteral getNullLiteral(JavacTreeMaker treeMaker) {
        return treeMaker.Literal(TypeTag.typeTag("BOT"), null);
    }

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

    @Override
    public void endVisitStatement(JavacNode statementNode, JCTree statement) {

    }
}
