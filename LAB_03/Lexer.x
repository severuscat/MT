{

{-# OPTIONS_GHC -fno-warn-unused-binds          #-}
{-# OPTIONS_GHC -fno-warn-missing-signatures    #-}
{-# OPTIONS_GHC -fno-warn-unused-matches        #-}
{-# OPTIONS_GHC -fno-warn-unused-imports        #-}
{-# OPTIONS_GHC -fno-warn-name-shadowing        #-}
{-# OPTIONS_GHC -fno-warn-tabs                  #-}
{-# OPTIONS_GHC -funbox-strict-fields           #-}


}

%wrapper "basic"

tokens :-

  :                  { const ColonT }
  ";"                { const SemicolonT }
  \.\"\ [^\"]*\"     { drop 3 >>> init >>> T.pack >>> StrOutputT }
  ~$white+           { T.pack >>> WordT }
  $white+            ;

{

data Token = WordT Text | StrOutputT Text | ColonT | SemicolonT deriving Show

}
