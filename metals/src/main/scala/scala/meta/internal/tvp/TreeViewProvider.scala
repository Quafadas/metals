package scala.meta.internal.tvp

import scala.meta.io.AbsolutePath

import org.eclipse.{lsp4j => l}

trait TreeViewProvider {
  val Project = TreeViewProvider.Project
  val Build = TreeViewProvider.Build
  val Help = TreeViewProvider.Help
  def init(): Unit = ()
  def reset(): Unit = ()
  def children(
      params: TreeViewChildrenParams
  ): MetalsTreeViewChildrenResult = MetalsTreeViewChildrenResult(Array.empty)
  def reveal(
      path: AbsolutePath,
      pos: l.Position,
  ): Option[TreeViewNodeRevealResult] = None
  def onCollapseDidChange(
      params: TreeViewNodeCollapseDidChangeParams
  ): Unit = ()
  def parent(
      params: TreeViewParentParams
  ): TreeViewParentResult = TreeViewParentResult()
  def onVisibilityDidChange(
      params: TreeViewVisibilityDidChangeParams
  ): Unit = ()
}

object TreeViewProvider {
  val Project = "metalsPackages"
  val Build = "metalsBuild"
  val Help = "metalsHelp"
}
