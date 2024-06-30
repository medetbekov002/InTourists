package com.dev.intourist.ui.screen.onboardingimport android.view.LayoutInflaterimport android.view.ViewGroupimport android.widget.Buttonimport android.widget.ImageButtonimport androidx.core.view.isVisibleimport androidx.recyclerview.widget.RecyclerViewimport com.dev.intourist.Rimport com.dev.intourist.databinding.ItemOnboardingBindingimport com.dev.intourist.ui.model.OnBoardingimport com.google.android.material.button.MaterialButtonclass OnBoardingAdapter(private val clicks: Result) : RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {    private val arrayList = arrayListOf(        OnBoarding(            isBack = false,            title = "Идеальные туры \n" +                    "в один клик",            desc = "Запланированные туры по доступным ценам",            img = R.drawable.on_boarding_img_1        ),        OnBoarding(            isBack = true,            title = "Легкий поиск \n" +                    "и бронирование",            desc = "Путешествуй с комфортом и уверенностью",            img = R.drawable.on_boarding_img_2        ),        OnBoarding(            isBack = true,            title = "Открой удивительные \n" +                    "места нашей страны",            desc = "Самые яркие впечатления ждут тебя",            img = R.drawable.on_boarding_img_3        ),    )    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {        return OnBoardingViewHolder(            ItemOnboardingBinding.inflate(                LayoutInflater.from(parent.context),                parent,                false            )        )    }    override fun getItemCount() = arrayList.size    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {        holder.bind(arrayList[position], position)    }    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :        RecyclerView.ViewHolder(binding.root) {        fun bind(onBoarding: OnBoarding, pos: Int) {            with(binding) {                btnBack.setOnClickListener {                    clicks.clickBack(btnBack)                }                btnNext.setOnClickListener {                    clicks.clickNext(btnNext, adapterPosition)                }                tvSkip.setOnClickListener {                    clicks.clickSkip()                }                tvTitle.text = onBoarding.title                tvDesc.text = onBoarding.desc                imgMain.setImageResource(onBoarding.img)                btnBack.isVisible = onBoarding.isBack               /* btnNext.translationX = (-100).toFloat()                btnNext.animate().translationX(0F).setDuration(2000).start()*/            }        }    }    interface Result{        fun clickNext(btnNext: Button, pos: Int)        fun clickBack(btnBack: ImageButton)        fun clickSkip()    }}