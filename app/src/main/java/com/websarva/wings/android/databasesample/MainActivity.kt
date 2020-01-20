class MainActivity :AppCompatActivity() {
    /**
     * 選択されたカクテルの主キーIDを表すフィールド
     */
    private var _cocktailId = -1
    /**
     * 選択されたカクテル名を表すフィールド
     */
    private var _cocktaiName = ""

    override fun onCreate(savedeInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //カクテルリスト用ListView(lvCocktail)を取得
        val lvCocktail = findViewById<ListView>(R.id.lvCocktail)
        //ｌｖCocktailにリスナを登録
        lvCocktail.onItemClickListener = ListItemClickListener()
    }

    /**
     * 保存ボタンがタップされた時の処理メソッド
     */
    fun onSaveButtonClick(view: view) {
        //感想欄を取得
        val etNote = findViewById<EditText>(R.id.etNote)
        //感想欄の入力値を消去
        etNote.setText("")
        //カクテル名を表示するTextViewを取得
        val tvCocktaiName = findViewById<TextView>(R.id.tvCocktaiName)
        //カクテル名を「未選択」に変更
        tvCocktaiName.text = getString(R.string.tv_name)
        //保存ボタンを取得
        val btnSave = findViewById<Button>(R.id.btnSave)
        //保存ボタンをタップできないように変更
        btnSave.isEnabled = false
    }

    /**
     * リストがタップされたときの処理が記述されたメンバクラス
     */
    private inner class ListItemClickListener : AdapteyView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: view, position: Int, id: Long) {
            //タップされた行番号をフィールドの主キーIDに代入
            _cocktaiId = position
            //タップされた行のデータを取得。これがカクテル名となるので、フィールドに代入
            _cocktailName = parent.getItemAtPosition(position) as String
            //カクテル名を表示するText Viewを取得
            var tvCocktaiName = findViewById<TextView>(R.idd.tvCocktailNAme)
            //カクテル名を表示するText Viewに表示カクテル名を設定
            tvCocktaiName.text = _cocktailName
            //保存ボタンを取得
            val btnSave = findViewById<Button>(R.id.btnSave)
            //保存ボタンをタップできるように設定
            btnSave.isEnabled = true
        }
    }
}