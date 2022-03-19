package com.example.kotlin1dz1.presentation.ui.fragments.books

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin1dz1.R
import com.example.kotlin1dz1.databinding.FragmentBooksBinding
import com.example.kotlin1dz1.models.LanguageModel
import com.example.kotlin1dz1.presentation.base.BaseFragment
import com.example.kotlin1dz1.presentation.ui.adapters.MovAdapter

class BooksFragment : BaseFragment<FragmentBooksBinding>(
    R.layout.fragment_books

) {
    override val binding: FragmentBooksBinding by viewBinding(FragmentBooksBinding::bind)
    private val sharedViewModel: MovViewModel by activityViewModels()
    private val adapter = MovAdapter { BookModel -> onClick(BookModel) }

    override fun setupViews() {
        initAdapter()
    }

    private fun initAdapter() {
        adapter.setList(sharedViewModel.getBooks())
        binding.recyclerview.adapter = adapter
    }

    private fun onClick(model: LanguageModel) {
        sharedViewModel.putDescription(model.description)
        findNavController().navigate(R.id.booksDetailsFragment)
    }
}