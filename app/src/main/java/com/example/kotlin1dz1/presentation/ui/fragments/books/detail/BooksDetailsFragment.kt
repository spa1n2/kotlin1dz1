package com.example.kotlin1dz1.presentation.ui.fragments.books.detail

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin1dz1.R
import com.example.kotlin1dz1.databinding.FragmentBooksDetailsBinding

import com.example.kotlin1dz1.presentation.base.BaseFragment
import com.example.kotlin1dz1.presentation.ui.fragments.books.MovViewModel
import kotlinx.coroutines.launch

class BooksDetailsFragment : BaseFragment<FragmentBooksDetailsBinding>(
    R.layout.fragment_books_details
) {


    override val binding: FragmentBooksDetailsBinding by viewBinding(FragmentBooksDetailsBinding::bind)
    private val sharedViewModel: MovViewModel by activityViewModels()

    override fun setupViews() {
        viewLifecycleOwner.lifecycleScope.launch {
            sharedViewModel.description.observe(viewLifecycleOwner) { description ->
                binding.title.text = description.toString()

            }
        }
    }
}