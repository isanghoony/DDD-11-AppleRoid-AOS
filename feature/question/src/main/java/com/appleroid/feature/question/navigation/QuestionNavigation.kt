package com.appleroid.feature.question.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.navigation
import androidx.navigation.compose.composable
import com.appleroid.feature.question.QuestionRoute

const val QUESTION_GRAPH_ROUTE_PATTERN = "question_graph"
const val QUESTION_ROUTE = "question_route"

fun NavController.navigationToQuestionGraph(navOptions: NavOptions? = null){
    this.navigate(QUESTION_GRAPH_ROUTE_PATTERN, navOptions)
}

fun NavGraphBuilder.questionGraph(
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = QUESTION_GRAPH_ROUTE_PATTERN,
        startDestination = QUESTION_ROUTE,
    ){
        composable(route = QUESTION_ROUTE) {
            QuestionRoute()
        }
        nestedGraphs()
    }
}