package org.example

import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.getAnnotationsByType
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration

class KspProcessor(private val env: SymbolProcessorEnvironment) : SymbolProcessor {
    @OptIn(KspExperimental::class)
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val ksAnnotated = resolver.getSymbolsWithAnnotation(JavaAnnotationWithList::class.qualifiedName.toString())
        ksAnnotated.forEach {
            if (it is KSClassDeclaration) {
                it.getAnnotationsByType(JavaAnnotationWithList::class).apply {
                    this.forEach { it.testList }
                }
            }
        }
        return emptyList()
    }
}