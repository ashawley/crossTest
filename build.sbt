import sbtcrossproject.{crossProject, CrossType}

name := "Foo root project"

val sharedSettings = Seq(
  scalaVersion := "2.11.8",
  crossScalaVersions in ThisBuild := {
    val java = System.getProperty("java.version")
    if (java.startsWith("1.6.") || java.startsWith("1.7."))
      Seq("2.10.6", "2.11.8")
    else if (java.startsWith("1.8.") || java.startsWith("1.9."))
      Seq("2.12.1")
    else
      sys.error(s"Scala version(s) for Java $java is unknown")
  },
  publish := {},
  publishLocal := {},
  name := "foo",
  version := "0.1-SNAPSHOT"
)

lazy val foo = 
  crossProject(JSPlatform, JVMPlatform, NativePlatform).
    crossType(CrossType.Pure).
    settings(sharedSettings).
    jsSettings(/* ... */).
    jvmSettings(
      libraryDependencies += "junit" % "junit" % "4.12" % "test",
      libraryDependencies += "com.novocode" % "junit-interface" % "0.10" % "test"
    ).
    nativeSettings(/* ... */)

lazy val fooJVM = foo.jvm
lazy val fooJS = foo.js
lazy val fooNative = foo.native
