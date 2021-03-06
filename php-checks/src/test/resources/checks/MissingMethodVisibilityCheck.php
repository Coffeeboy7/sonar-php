<?php

abstract class C1
{
    static function f() { return; }          // NOK {{Explicitly mention the visibility of this method "f".}}
    abstract function g();                   // NOK {{Explicitly mention the visibility of this method "g".}}
    function h() {return; }                  // NOK {{Explicitly mention the visibility of this method "h".}}

    private static function i() { return; }  // OK
    protected abstract function j();         // OK
    public function k() { return; }          // OK
}

class C2 {

  function C2 () { return; }                  // NOK {{Explicitly mention the visibility of this constructor "C2".}}
  function __destruct() { return; }           // NOK {{Explicitly mention the visibility of this destructor "__destruct".}}
}

class C3 {
  function __construct() { return; }          // NOK {{Explicitly mention the visibility of this constructor "__construct".}}
}

$x = new class {
  static function f() { return; }             // NOK {{Explicitly mention the visibility of this method "f".}}
  function __construct() { return; }          // NOK {{Explicitly mention the visibility of this constructor "__construct".}}
};
